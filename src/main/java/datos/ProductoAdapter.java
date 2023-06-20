package datos;

import com.google.gson.*;
import modelo.Producto;

import java.lang.reflect.Type;

public class ProductoAdapter implements JsonSerializer<Producto>, JsonDeserializer<Producto> {

    @Override
    public JsonElement serialize(Producto src, Type typeOfSrc, JsonSerializationContext context) {
        JsonObject result = new JsonObject();
        result.add("type", new JsonPrimitive(src.getClass().getName()));
        result.add("data", context.serialize(src, src.getClass()));
        return result;
    }

    @Override
    public Producto deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) {
        JsonObject jsonObject = json.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        JsonElement element = jsonObject.get("data");

        try {
            return context.deserialize(element, Class.forName(type));
        } catch (ClassNotFoundException e) {
            throw new JsonParseException("Unknown element type: " + type, e);
        }
    }
}
