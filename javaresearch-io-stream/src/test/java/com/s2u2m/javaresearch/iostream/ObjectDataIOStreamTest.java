package com.s2u2m.javaresearch.iostream;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.*;

public class ObjectDataIOStreamTest {

    @Test
    public void testDataStream() throws IOException {
        SerializableTestObject obj = new SerializableTestObject()
                .setId(10).setValue("hello world");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        dataOutputStream.writeInt(obj.getId());
        dataOutputStream.writeUTF(obj.getValue());
        dataOutputStream.close();
        byte[] bs = outputStream.toByteArray();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bs);
        DataInputStream dataInputStream = new DataInputStream(inputStream);
        assertEquals(obj.getId().intValue(), dataInputStream.readInt());
        assertTrue(obj.getValue().equals(dataInputStream.readUTF()));
        dataInputStream.close();
    }

    @Test
    public void testSerializableObjectStream() throws IOException, ClassNotFoundException {
        SerializableTestObject obj = new SerializableTestObject()
                .setId(10).setValue("hello world");

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(obj);
        objectOutputStream.close();
        byte[] bs = outputStream.toByteArray();

        ByteArrayInputStream inputStream = new ByteArrayInputStream(bs);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        SerializableTestObject actual = (SerializableTestObject) objectInputStream.readObject();
        assertEquals(obj.getId(), actual.getId());
        assertTrue(obj.getValue().equals(actual.getValue()));
        objectInputStream.close();
    }
}
