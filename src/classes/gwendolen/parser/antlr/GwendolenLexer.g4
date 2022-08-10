// ----------------------------------------------------------------------------
// Copyright (C) 2022 Louise A. Dennis
// 
// This file is part of Gwendolen
//
// Gwendolen is free software; you can redistribute it and/or
// modify it under the terms of the GNU Lesser General Public
// License as published by the Free Software Foundation; either
// version 3 of the License, or (at your option) any later version.
// 
// Gwendolen is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
// Lesser General Public License for more details.
// 
// You should have received a copy of the GNU Lesser General Public
// License along with Gwendolen if not, write to the Free Software
// Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
// 
// To contact the authors:
// http://www.csc.liv.ac.uk/~lad
//----------------------------------------------------------------------------

lexer grammar GwendolenLexer;


GWENDOLEN	:'GWENDOLEN' ;

NAME	:	':name:';
AGNAME	:	'ag1';

COMMENT : '/*' .*? '*/' -> skip ;
LINE_COMMENT : '//' ~[\n]* -> skip ;
NEWLINE:'\r'? '\n' -> skip  ;
WS  :   (' '|'\t') -> skip ;


