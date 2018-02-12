package com.basico.mongodb.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;

import com.basico.mongodb.converter.ClimaConverter;
import com.basico.mongodb.model.Clima;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

public class ClimaDAO {

	private DBCollection col;

	public ClimaDAO(MongoClient mongo) {
		this.col = mongo.getDB("Tiempo").getCollection("Climas");
	}

	public Clima createClima(Clima c) {
		DBObject doc = ClimaConverter.toDBObject(c);
		this.col.insert(doc);
		ObjectId id = (ObjectId) doc.get("_id");
		c.setId(id.toString());
		return c;
	}

	public void updateClima(Clima c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getId())).get();
		this.col.update(query, ClimaConverter.toDBObject(c));
	}

	public List<Clima> readAllClima() {
		List<Clima> data = new ArrayList<Clima>();
		DBCursor cursor = col.find();
		while (cursor.hasNext()) {
			DBObject doc = cursor.next();
			Clima c = ClimaConverter.toClima(doc);
			data.add(c);
		}
		return data;
	}

	public void deleteClima(Clima c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getId())).get();
		this.col.remove(query);
	}

	public Clima readClima(Clima c) {
		DBObject query = BasicDBObjectBuilder.start()
				.append("_id", new ObjectId(c.getId())).get();
		DBObject data = this.col.findOne(query);
		return ClimaConverter.toClima(data);
	}

}