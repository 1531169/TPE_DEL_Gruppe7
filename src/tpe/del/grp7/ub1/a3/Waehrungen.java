package tpe.del.grp7.ub1.a3;

/**
 * This class delivers created objects of the class Waehrung,
 * so that they can be reused simply within the program.
 * This class is abstract, so no instances of this class can be created.
 * Furthermore its attributes are constants declared as public static final. 
 * 
 * @author Gruppe7
 * @version 20.03.2016
 *
 */
abstract class Waehrungen {
	
	public static final Waehrung dollar = new Waehrung("US-Dollar", "$", 1.0000);
	public static final Waehrung euro = new Waehrung("Euro", "€", 1.2690);
	public static final Waehrung yen = new Waehrung("Yen", "¥", 0.0091);
	public static final Waehrung rubel = new Waehrung("Rubel", "RUB", 0.0255);
	public static final Waehrung franken = new Waehrung("Schweizer Franken", "CHF", 1.0509);
		
}
