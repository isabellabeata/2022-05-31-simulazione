package it.polito.tdp.nyc.model;

import java.time.Duration;

public class Event implements Comparable<Event> {
	
	public enum EventType{
		ANALISI_HOTSPOT,
		SPOSTAENTO_QUARTIERE
	}
	
	private EventType type;
	private int time;
	private Tecnico tecnico;
	private Hotspot hotspot;
	public Event(EventType type, int time, Tecnico tecnico, Hotspot hotspot) {
		super();
		this.type = type;
		this.time = time;
		this.tecnico = tecnico;
		this.hotspot = hotspot;
	}
	public EventType getType() {
		return type;
	}
	public void setType(EventType type) {
		this.type = type;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Tecnico getTecnico() {
		return tecnico;
	}
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	public Hotspot getHotspot() {
		return hotspot;
	}
	public void setHotspot(Hotspot hotspot) {
		this.hotspot = hotspot;
	}
	@Override
	public int compareTo(Event o) {
		// TODO Auto-generated method stub
		return this.time-o.getTime();
	}
	
	

}
