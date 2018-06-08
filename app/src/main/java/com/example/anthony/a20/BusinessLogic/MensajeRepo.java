package com.example.anthony.a20.BusinessLogic;

import android.util.JsonReader;

import com.example.anthony.a20.Entities.Mensaje;
import com.example.anthony.a20.Entities.Profesor;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;
import java.util.ArrayList;

public class MensajeRepo implements  IMensajeRepo{

    @Override
    public Mensaje getMensaje(int id) {
        ArrayList<Mensaje> mensajes=new ArrayList<>();
        URL apiUrl=null;

        try {
            apiUrl =
                    new URL("http://192.168.1.11:9990/api/mensajes?id="+id);

            //Crear conexión
            HttpURLConnection myConnection =
                    (HttpURLConnection) apiUrl.openConnection();

            //Procesar respuesta
            if (myConnection.getResponseCode()== 200){
                //Éxito
                //Further procesamiento aqui

                //Leyendo la respuesta
                InputStream responseBody= myConnection.getInputStream();

                //Usando lectura para respuesta
                InputStreamReader responseBodyReader=
                        new InputStreamReader(responseBody,"UTF-8");

                //Leyenso jason
                JsonReader jsonReader=new JsonReader(responseBodyReader);

                //Comenzar lectura del arreglo
                jsonReader.beginArray();

                //Leyendo elementos
                while (jsonReader.hasNext()){
                    //Leer cada objeto
                    jsonReader.beginObject();
                    int idmensaje =0;
                    String hora ="";
                    Date fecha=null;
                    String contenido ="";
                    int id_padre =0;
                    int id_profe =0;
                    String remitente ="";

                    while(jsonReader.hasNext()){
                        String property=jsonReader.nextName();
                        switch(property.toLowerCase()){
                            case "idmensaje":
                                idmensaje=jsonReader.nextInt();
                                break;
                            case "hora":
                                hora=jsonReader.nextString();
                                break;
                            case "fecha":
                                fecha=Date.valueOf(jsonReader.nextString());
                                break;
                            case "contenido":
                                contenido=jsonReader.nextString();
                                break;
                            case "id_padre":
                                id_padre=jsonReader.nextInt();
                                break;
                            case "id_profe":
                                id_profe=jsonReader.nextInt();
                                break;
                            case "remitente":
                                remitente=jsonReader.nextString();
                                break;

                            default:
                                jsonReader.skipValue();
                                break;
                        }
                        //Agregar item a la lista

                    }
                    Mensaje obj=new Mensaje( idmensaje,  hora,  fecha,  contenido,  id_padre,  id_profe,  remitente);
                    mensajes.add(obj);
                    jsonReader.endObject();
                }
                jsonReader.endArray();
                jsonReader.close();
                myConnection.disconnect();

            } else   {

            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return mensajes.get(0) ;
    }

    @Override
    public ArrayList<Mensaje> getMensajes() {
        return null;
    }

    @Override
    public boolean createMensaje(Mensaje obj) {
        return false;
    }
}
