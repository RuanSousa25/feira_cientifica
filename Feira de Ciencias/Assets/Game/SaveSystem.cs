using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.Networking;

using System;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;


[Serializable]
public class SaveData
{
    public string codeName;
    public int points;
}

public static class SaveSystem
{
    private static string public_key = "6289978d8f40bb11c05666db";
    private static string private_key = "XGuaan_X0E610Zj0viJJYg0AQjISpIrEm6g5Sihv1tDA";
    private static string url = "http://dreamlo.com/lb/";

    public static void SaveData(string name,int points)
    {
        SaveData newdata = new SaveData();
        newdata.codeName = name;
        newdata.points = points;

        SaveData olddata = LoadData();

        if(!Directory.Exists(Application.dataPath + "/Saves"))
        {
            Directory.CreateDirectory(Application.dataPath + "/Saves");
            SaveData(newdata.codeName, newdata.points);
        }
        else
        {
            if (newdata.points > olddata.points)
            {
                BinaryFormatter bf = new BinaryFormatter();
                FileStream f = File.Create(Application.dataPath + "/Saves/save.dat");
                
                bf.Serialize(f, newdata);

                f.Close();
            }
        }
    }

    public static SaveData LoadData()
    {
        string path = Application.dataPath + "/Saves/save.dat";

        BinaryFormatter bf = new BinaryFormatter();

        if (!Directory.Exists(Application.dataPath + "/Saves")) return new SaveData();
        if (!File.Exists(path)) return new SaveData();
        
        FileStream f = File.Open(path, FileMode.Open);
        SaveData d = (SaveData)bf.Deserialize(f);
        f.Close();
        return d;


    }

    public static IEnumerator PostScores(SaveData data)
    {

        WWW request = new WWW($"{url}{private_key}/add/{WWW.EscapeURL(data.codeName)}/{data.points}");
        yield return request;
    }


    public static IEnumerator GetScores(MenuManager menu)
    {
        WWW request = new WWW($"{url}{public_key}/pipe/0/10");
        yield return request;

        string data = request.text;

        string[] entries = data.Split(new char[] { '\n' }, System.StringSplitOptions.RemoveEmptyEntries);
        for(int i = 0;i< entries.Length; i++)
        {
            string[] entryinfo = entries[i].Split(new char[] { '|' });
            string username = entryinfo[0];
            int score = int.Parse(entryinfo[1]);

            menu.AddP(i, username, score);
        }

    }
}
