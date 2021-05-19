package model;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.util.Map;


abstract class Base implements  BaseInterface{
    @Override
    public String plural() throws Exception {
        throw new Exception("No plural set on this model");
    }

    @Override
    public void all() {
        //todo
    }

    @Override
    public Base find(int id) {
        //todo
        return null;
    }

    @Override
    public Yaml getData() {
        Yaml yaml = new Yaml();
        InputStream inputStream = this.getClass()
                .getClassLoader()
                .getResourceAsStream("master.yaml");
        return yaml.load(inputStream);
    }
}
