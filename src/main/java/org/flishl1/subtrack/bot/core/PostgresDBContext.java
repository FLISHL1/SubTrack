package org.flishl1.subtrack.bot.core;

import org.telegram.telegrambots.abilitybots.api.db.DBContext;
import org.telegram.telegrambots.abilitybots.api.db.Var;

import java.io.IOException;
import java.util.*;

public class PostgresDBContext implements DBContext {
    @Override
    public <T> List<T> getList(String s) {
        return new ArrayList<>();
    }

    @Override
    public <K, V> Map<K, V> getMap(String s) {
        return new HashMap<>();
    }

    @Override
    public <T> Set<T> getSet(String s) {
        return new HashSet<>();
    }

    @Override
    public <T> Var<T> getVar(String s) {
        return null;
    }

    @Override
    public String summary() {
        return "1";
    }

    @Override
    public Object backup() {
        return null;
    }

    @Override
    public boolean recover(Object o) {
        return false;
    }

    @Override
    public String info(String s) {
        return "";
    }

    @Override
    public void commit() {

    }

    @Override
    public void clear() {

    }

    @Override
    public boolean contains(String s) {
        return false;
    }

    @Override
    public void close() throws IOException {

    }
}
