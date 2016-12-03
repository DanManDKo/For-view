package com.example.danman.translator.util;

import android.content.Context;
import android.content.res.XmlResourceParser;

import com.example.danman.translator.R;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by DanMan on 03.12.2016.
 */
public class XmlParser {
    private static Map<String, String> sDictionary = new LinkedHashMap<>();

    public static Map<String, String> getDictionary(Context context) {
        sDictionary.putAll(parseXml(context.getResources().getXml(R.xml.ae)));
        sDictionary.putAll(parseXml(context.getResources().getXml(R.xml.fl)));
        sDictionary.putAll(parseXml(context.getResources().getXml(R.xml.mp)));
        sDictionary.putAll(parseXml(context.getResources().getXml(R.xml.qz)));
        return sDictionary;
    }

    private static Map<String, String> parseXml(XmlResourceParser xpp) {
        Map<String, String> dictionary = new LinkedHashMap<>();
        boolean isTranslation = false;
        boolean isExample = false;
        String translation = "";
        String original = "";
        try {
            while (xpp.getEventType() != XmlPullParser.END_DOCUMENT) {

                switch (xpp.getEventType()) {
                    case XmlPullParser.START_TAG:
                        String name = xpp.getName();
                        if (name.equals("translations"))
                            isTranslation = true;
                        if (name.equals("example"))
                            isExample = true;
                        if (name.equals("card")) {
                            translation = "";
                            original = "";
                        }
                        break;
                    case XmlPullParser.END_TAG:
                        if (xpp.getName().equals("translations"))
                            isTranslation = false;
                        if (xpp.getName().equals("example"))
                            isExample = false;
                        if (xpp.getName().equals("card")) {
                            dictionary.put(original, translation);
                        }
                        break;
                    case XmlPullParser.TEXT:
                        if (isExample)
                            break;
                        if (isTranslation)
                            translation += xpp.getText() + " ";
                        else original += xpp.getText();
                        break;
                }
                xpp.next();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dictionary;
    }
}
