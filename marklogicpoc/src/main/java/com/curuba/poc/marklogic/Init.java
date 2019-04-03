package com.curuba.poc.marklogic;

import com.fasterxml.jackson.databind.JsonNode;
import com.marklogic.client.DatabaseClient;
import com.marklogic.client.DatabaseClientFactory;
import com.marklogic.client.document.JSONDocumentManager;
import com.marklogic.client.io.JacksonHandle;
import com.marklogic.client.DatabaseClientFactory.Authentication;

/**POC to connect java with marklogic database*/
public class Init {

    public static void main(String... args) {
        DatabaseClient client = DatabaseClientFactory.newClient("localhost", 8051, "user-rol-test", "admin",
                Authentication.DIGEST);
        JSONDocumentManager docMgr = client.newJSONDocumentManager();
        JacksonHandle handle = new JacksonHandle();
        docMgr.read("/fun-test/polo/hello02.json", handle);
        JsonNode doc = handle.get();
        System.out.println(doc);
        client.release();
    }


}
