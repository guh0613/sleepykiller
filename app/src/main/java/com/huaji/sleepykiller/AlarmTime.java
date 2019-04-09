package com.huaji.sleepykiller;

public class AlarmTime {
    
    private String Time;
	private String Date;

    public AlarmTime(String Time) {
        
        this.Time=Time;
		
    }

    public String getTime()
	{
        return Time;
    }

    public void setTime(String time)
	{
        Time = time;
    }
	
	
}
