package com.basico.mongodb.converter;

import org.bson.types.ObjectId;

import com.basico.mongodb.model.Clima;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;

public class ClimaConverter {

	public static DBObject toDBObject(Clima c) {

		BasicDBObjectBuilder builder = BasicDBObjectBuilder.start()
				.append("poblacion", c.getPoblacion()).append("litros", c.getLitros())
				.append("fecha", c.getFecha()).append("tempmax", c.getTempmax())
				.append("tempmin", c.getTempmin());
		if (c.getId() != null)
			builder = builder.append("_id", new ObjectId(c.getId()));
		return builder.get();
		}

	public static Clima toClima(DBObject doc) {
		Clima c = new Clima();
		c.setPoblacion((String) doc.get("poblacion"));
		c.setLitros((String) doc.get("litros"));
		c.setFecha((String) doc.get("fecha"));
		c.setTempmax((String) doc.get("tempmax"));
		c.setTempmin((String) doc.get("tempmin"));
		ObjectId id = (ObjectId) doc.get("_id");
		c.setId(id.toString());
		return c;
		}
	}