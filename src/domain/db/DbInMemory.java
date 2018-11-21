package domain.db;

import domain.model.DatabaseModel;
import domain.model.Person;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbInMemory<T extends DatabaseModel> {
	private Map<Integer, T> records = new HashMap<>();

    public boolean contains(String id) {
		return records.containsKey(id);
	}
	
    public T get(String id){
		if(id == null){
			throw new DbException("No id given");
		}
		return records.get(id);
	}
	
    public List<T> getAll(){
		return new ArrayList<T>(records.values());
	}

    public void add(T record){
		if(record == null){
			throw new DbException("No person given");
		}
		if (records.containsKey(record.getId())) {
			throw new DbException("User already exists");
		}
		records.put(record.getId(), record);
	}
	
    public void update(T record){
		if(record == null){
			throw new DbException("No person given");
		}
		if(!records.containsKey(record.getId())){
			throw new DbException("No person found");
		}
		records.put(record.getId(), record);
	}
	
    public void delete(String id){
		if(id == null){
			throw new DbException("No id given");
		}
		records.remove(id);
	}

    public int getNumberOfPersons() {
		return records.size();
	}
}
