package de.hsma.imb.ss16.tpe.del.grp7.ub2.a1.crypter;

public class KeySettings {
	private boolean minLengthRequired = false;
	private boolean maxLengthRequired = false;
	private int minLength = 1;
	private int maxLength = 100;
	private String regexAllowedLetters = "[a-zA-Z]+";

	public KeySettings() {	
	}
	
	/**
	 * @return the requireMinLength
	 */
	public boolean isMinLengthRequired() {
		return minLengthRequired;
	}
	
	/**
	 * @param requiredMinLength the requireMinLength to set
	 */
	public void setMinLengthRequired(boolean minLengthRequired) {
		this.minLengthRequired = minLengthRequired;
	}
	
	/**
	 * @return the requireMaxLength
	 */
	public boolean isMaxLengthRequired() {
		return maxLengthRequired;
	}
	
	/**
	 * @param requiredMaxLength the requireMaxLength to set
	 */
	public void setMaxLengthRequired(boolean maxLengthRequired) {
		this.maxLengthRequired = maxLengthRequired;
	}
	
	/**
	 * @return the minLength
	 */
	public int getMinLength() {
		return minLength;
	}
	
	/**
	 * @param minLength the minLength to set
	 */
	public void setMinLength(int minLength) {
		this.minLength = minLength;
	}
	
	/**
	 * @return the maxLength
	 */
	public int getMaxLength() {
		return maxLength;
	}
	
	/**
	 * @param maxLength the maxLength to set
	 */
	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}
	
	/**
	 * @return the regexAllowedLetters
	 */
	public String getRegexAllowedLetters() {
		return regexAllowedLetters;
	}

	/**
	 * @param regexAllowedLetters the regexAllowedLetters to set
	 */
	public void setRegexAllowedLetters(String regexAllowedLetters) {
		this.regexAllowedLetters = regexAllowedLetters;
	}
}