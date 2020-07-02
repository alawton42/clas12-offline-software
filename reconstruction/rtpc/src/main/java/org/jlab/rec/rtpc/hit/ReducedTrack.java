package org.jlab.rec.rtpc.hit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ReducedTrack {

	private List<HitVector> _hits = new ArrayList<HitVector>();
	private boolean _flagTrack = false; 
	
	public ReducedTrack() {
		//Default Constructor
	}
	
	public void addHit(HitVector v) {
		_hits.add(v);
	}
	
	public void sortHits() {
		Collections.sort(_hits, new Comparator<HitVector>() {
			  @Override
			  public int compare(HitVector v1, HitVector v2) {
			    return Double.compare(v2.time(),v1.time());
			  }
		});
	}
	
	public double getSmallT() {
		return _hits.get(_hits.size()-1).time();
	}
	
	public double getLargeT() {
		return _hits.get(0).time();
	}
	
	public Set<Integer> getAllPads() {
		Set<Integer> pads = new HashSet<Integer>();
		for(HitVector v : _hits) {
			pads.add(v.pad());
		}
		return pads;
	}
	
	public List<HitVector> getAllHits() {
		return _hits;
	}
	
	public void flagTrack() {
		_flagTrack = true;
	}
	
	public boolean isTrackFlagged() {
		return _flagTrack;
	}
        
        public HitVector getLastHit(){
                return _hits.get(_hits.size()-1);
        }
	
}
