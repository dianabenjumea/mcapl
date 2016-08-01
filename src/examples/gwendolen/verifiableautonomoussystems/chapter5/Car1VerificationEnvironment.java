package gwendolen.verifiableautonomoussystems.chapter5;

import java.util.HashSet;
import java.util.Set;

import ail.syntax.Message;
import ail.syntax.Predicate;
import gwendolen.mas.VerificationofAutonomousSystemsEnvironment;

public class Car1VerificationEnvironment extends
		VerificationofAutonomousSystemsEnvironment {

	@Override
	public Set<Predicate> generate_sharedbeliefs() {
		Set<Predicate> beliefs = new HashSet<Predicate>();
		beliefs.add(new Predicate("at_speed_limit"));
		beliefs.add(new Predicate("started"));
		return beliefs;
	}

	@Override
	public Set<Message> generate_messages() {
		return new HashSet<Message>();
	}

}
