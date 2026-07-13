package br.edu.ifba.inf011.model.playlist;

public interface PlaylistItem {
	public static Double BAND_PER_SECOND = 1.5;
	public String toXML();
	public Double getBandwidth(Double bandPerSecond);
}

