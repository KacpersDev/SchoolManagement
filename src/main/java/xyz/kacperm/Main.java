package xyz.kacperm;

import xyz.kacperm.database.Mongo;
import xyz.kacperm.handler.Program;

public class Main {

    public static Mongo mongoHandler = new Mongo("mongodb+srv://rootuser:123Zenia@cluster0.t1s4ccm.mongodb.net/?retryWrites=true&w=majority");

    public static void main(String[] args) {
        mongoHandler.connect();
        new Program().handle();
    }
}
