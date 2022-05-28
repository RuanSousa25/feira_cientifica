using System.Collections;
using System.Collections.Generic;
using System.IO;
using System.Runtime.Serialization.Formatters.Binary;
using UnityEngine;


[System.Serializable]
public class Achievement
{
    public int id;
    public string title;
    public string desc;
    public int MaxProgress;
    public int currectProgress;
}


public class AchievementsSystem
{

    public static List<Achievement> Achievements = new List<Achievement>
    {
        new Achievement{id = 0,title = "Começando!",desc = "Primeira vez Jogando.",MaxProgress = 1,currectProgress = 0 },
        new Achievement{id = 1,title = "Quanta Fumaça!",desc = "Quebre o computador dez vezes.",MaxProgress = 10,currectProgress = 0 },
        new Achievement{id = 2,title = "Dedo escorregadio",desc = "Após errar a sequência 100 vezes.",MaxProgress = 100,currectProgress = 0 },
        new Achievement{id = 3,title = "Por pouco",desc = "Alimentou o gato no último segundo",MaxProgress = 100,currectProgress = 0 },

        new Achievement{id = 4,title = "Progamador amador",desc = "5 acertos seguidos",MaxProgress = 1,currectProgress = 0},
        new Achievement{id = 5,title = "Progamador intermediário",desc = "10 acertos seguidos",MaxProgress = 1,currectProgress = 0},
        new Achievement{id = 6,title = "Progamador profissional",desc = "25 acertos seguidos",MaxProgress = 1,currectProgress = 0},
        new Achievement{id = 7,title = "Rei da progamação",desc = "40 acertos seguidos",MaxProgress = 1,currectProgress = 0},
        new Achievement{id = 8,title = "isso é real?",desc = "60 acertos seguidos",MaxProgress = 1,currectProgress = 0},

        new Achievement{id = 9,title = "adimirador de gatos",desc = "alimente seu gato 10 vezes",MaxProgress = 10,currectProgress = 0},
        new Achievement{id = 10,title = "amante de gatos",desc = "alimente seu gato 30 vezes",MaxProgress = 30,currectProgress = 0},
        new Achievement{id = 11,title = "fanático por gatos",desc = "alimente seu gato 60 vezes",MaxProgress = 60,currectProgress = 0},
        new Achievement{id = 12,title = "\"Desculpe, mas prefiro gatos\"",desc = "alimente seu gato 100 vezes",MaxProgress = 100,currectProgress = 0},

        //new Achievement{id = 4,title = "Por pouco",desc = "Alimentou o gato no último segundo",MaxProgress = 100,currectProgress = 0 },
    };
   

    public static void SaveAchievements()
    {
        BinaryFormatter bf = new BinaryFormatter();

        if (!Directory.Exists(Application.dataPath + "/Saves"))
        {
            Directory.CreateDirectory(Application.dataPath + "/Saves");
            SaveAchievements();
        }
        else
        {
            FileStream f = File.Create(Application.dataPath + "/Saves/Achievements.dat");

            bf.Serialize(f, Achievements);

            f.Close();
        }

    }

    public static void LoadAchievements()
    {
        BinaryFormatter bf = new BinaryFormatter();

        string path = Application.dataPath + "/Saves/Achievements.dat";

        if (!Directory.Exists(Application.dataPath + "/Saves") || !File.Exists(path)) SaveAchievements();

        FileStream f = File.Open(path, FileMode.Open);
        List <Achievement> achs = (List<Achievement>)bf.Deserialize(f);

        foreach(Achievement a in achs)
        {
            Achievement e = Achievements.Find(x => x.id == a.id);
            if (e != null)
            {
                int index = Achievements.IndexOf(e);
                Achievements[index].currectProgress = a.currectProgress;
            }
        }

        f.Close();
    }

    public static void AddProgress(int id)
    {
        Achievement a = Achievements.Find(x => x.id == id);
        if (a != null)
        {
            if (a.currectProgress < a.MaxProgress)
            {
                a.currectProgress += 1;
                if(a.currectProgress == a.MaxProgress)
                {
                    AlertBox.instance.SendWarn($"Conquista desbloqueada: {a.title}");
                    SaveAchievements();
                }
            }
        }
    }

}
