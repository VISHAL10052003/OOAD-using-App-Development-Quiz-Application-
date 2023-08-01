package com.pms.model;

public class Student {
    private int regno;
    private String name;
    private int webScore;
    private int sqlScore;
    private int javaScore;
    private int totalScore;

    // Getters and setters for all attributes

    @Override
    public String toString() {
        return String.format("Student [regno=%s, name=%s, webScore=%s, sqlScore=%s, javaScore=%s, totalScore=%s]",
                regno, name, webScore, sqlScore, javaScore, totalScore);
    }

	public int getRegno() {
		return regno;
	}

	public void setRegno(int regno) {
		this.regno = regno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWebScore() {
		return webScore;
	}

	public void setWebScore(int webScore) {
		this.webScore = webScore;
	}

	public int getSqlScore() {
		return sqlScore;
	}

	public void setSqlScore(int sqlScore) {
		this.sqlScore = sqlScore;
	}

	public int getJavaScore() {
		return javaScore;
	}

	public void setJavaScore(int javaScore) {
		this.javaScore = javaScore;
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}

	
	
}

