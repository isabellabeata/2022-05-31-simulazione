package it.polito.tdp.nyc.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleWeightedGraph;

import it.polito.tdp.nyc.db.NYCDao;

public class Model {
	
	private NYCDao dao;
	private Graph<String, DefaultWeightedEdge> grafo;
	private Simulator sim;
	
	
	
	public Model() {
		this.dao= new NYCDao();
		this.sim= new Simulator();
		
	}
	
	public List<String> geetAllProviders(){
		return this.dao.getAllProviders();
	}
	
	public List<String> getQuartieri(String provider) {
		return this.dao.getVertici(provider);
	}
	
	public void creaGrafo(String provider)
	{
		this.grafo= new SimpleWeightedGraph<String,DefaultWeightedEdge>(DefaultWeightedEdge.class);
		Graphs.addAllVertices(this.grafo, this.dao.getVertici(provider));
		
		List<Arco> archi= new ArrayList<Arco> (this.dao.getArco(provider));
		for (Arco a: archi) {
			if(!this.grafo.containsEdge(a.getCity1(), a.getCity2())) {
			Graphs.addEdgeWithVertices(this.grafo, a.getCity1(), a.getCity2(), a.getDistance());
			}
		}
		
		System.out.println("Grafo creato!"+"\n"+"#verici: "+ this.grafo.vertexSet().size()+"\n");
		System.out.println("#archi: "+ this.grafo.edgeSet().size()+"\n");
		
		
		
		
	}
	
	public String nVertici() {
		return "Grafo creato!"+"\n"+"#verici: "+ this.grafo.vertexSet().size()+"\n";
	}
	
	public String nArchi() {
		return "#archi: "+ this.grafo.edgeSet().size()+"\n";
	}
	
	public List<Arco> getQuartieriAdiacenti(String city){
		List<Arco> list= new LinkedList<>();
		
		for(String s : Graphs.neighborListOf(this.grafo, city)) {
			
			DefaultWeightedEdge e= this.grafo.getEdge(s, city);
			double peso= this.grafo.getEdgeWeight(e);
			Arco a= new Arco(city, s, peso);
			list.add(a);
		}
		
		Collections.sort(list);
		return list;
	}
	
}
