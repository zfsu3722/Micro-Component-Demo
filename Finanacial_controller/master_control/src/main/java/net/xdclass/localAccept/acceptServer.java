package net.xdclass.localAccept;

import java.util.HashMap;

public interface acceptServer {
    public HashMap<String,Object> acceptMassage(HashMap<String, Object> massage);
    public HashMap<String,Object> acceptCommand(HashMap<String, Object> massage);
}
