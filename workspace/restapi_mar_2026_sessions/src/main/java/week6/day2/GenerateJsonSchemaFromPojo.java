package week6.day2;

import com.github.victools.jsonschema.generator.OptionPreset;
import com.github.victools.jsonschema.generator.SchemaGenerator;
import com.github.victools.jsonschema.generator.SchemaGeneratorConfigBuilder;
import com.github.victools.jsonschema.generator.SchemaVersion;

public class GenerateJsonSchemaFromPojo {
	
	public static <T> String generate(Class<T> pojoClass) {
		// Step 1: Set the Configuration for the json schema using SchemaGeneratorConfigBuilder class
		SchemaGeneratorConfigBuilder schemaGeneratorConfigBuilder = new SchemaGeneratorConfigBuilder(SchemaVersion.DRAFT_7, OptionPreset.PLAIN_JSON);
	    // Step 2: Generate the json schema using SchemaGenerator class 
		// SchemaGenerator constructor argument type is SchmeaGeneatorConfig
		// build() -> will convert your SchemaGeneratorConfigBuilder object type to SchemaGeneratorConfig object type
		SchemaGenerator schemaGenerator = new SchemaGenerator(schemaGeneratorConfigBuilder.build());
		// Step 3: Call the generateSchema method to create json schema and add Parent pojo class as argument
		String jsonSchema = schemaGenerator.generateSchema(pojoClass).toPrettyString();
		return jsonSchema;
	}

}