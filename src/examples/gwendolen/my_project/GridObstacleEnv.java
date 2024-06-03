
package gwendolen.my_project;

import ail.mas.DefaultEnvironment;
import ail.syntax.*;
import ail.util.AILexception;
import ajpf.util.AJPFLogger;

/**

 */


public class GridObstacleEnv extends DefaultEnvironment {
	String logname = "gwendolen.my_project.GridObstacleEnv";

	int gridSize = 4;

	double obstacle_x = 0;
	double obstacle_y = 1;

	double robot_x = 0;
	double robot_y = 0;

	boolean obstacleFound = false;


	
	public Unifier executeAction(String agName, Action act) throws AILexception {
		Unifier u = new Unifier();

		if (act.getFunctor().equals("move_to")) {
			double x = ((NumberTerm) act.getTerm(0)).solve();
			double y = ((NumberTerm) act.getTerm(1)).solve();

			if (x >= 0 && x < gridSize && y >= 0 && y < gridSize) {
				Predicate at = new Predicate("at");
				at.addTerm(new NumberTermImpl(x));
				at.addTerm(new NumberTermImpl(y));

				Predicate old_pos = new Predicate("at");
				old_pos.addTerm(new NumberTermImpl(robot_x));
				old_pos.addTerm(new NumberTermImpl(robot_y));

				removePercept(agName, old_pos);
				addPercept(agName, at);

				robot_x = x;
				robot_y = y;

				if (robot_y == obstacle_y && robot_x == obstacle_x && !obstacleFound) {

					Predicate obstacle = new Predicate("obstacle");
					obstacle.addTerm(new NumberTermImpl(obstacle_x));
					obstacle.addTerm(new NumberTermImpl(obstacle_y));
					addPercept(agName, obstacle);
				}

			}
		} if (act.getFunctor().equals("stop")){
			if (robot_x == obstacle_x) {
				if (robot_y == obstacle_y && !obstacleFound) {
					Predicate rubble = new Predicate("obstacle");
					rubble.addTerm(new NumberTermImpl(obstacle_x));
					rubble.addTerm(new NumberTermImpl(obstacle_y));

					removePercept(agName, rubble);

					Predicate find = new Predicate("find");
					find.addTerm(new Predicate("obstacle"));
					addPercept(agName, find);
					obstacleFound = true;
				}
			}
		}

		super.executeAction(agName, act);

		if (obstacleFound) {
			AJPFLogger.info(logname, "OBSTACLE FOUND AT (" + obstacle_x + ", " + obstacle_y + ")");
			obstacleFound = false; // Reset for future checks
		}

		return u;
	}

}
