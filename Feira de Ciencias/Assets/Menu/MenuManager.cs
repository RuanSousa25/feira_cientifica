using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using TMPro;
using UnityEngine.UI;

public class MenuManager : MonoBehaviour
{

    public TMP_Text highscoredisplay;
    private SaveData data;

    public GameObject personinleader;
    public GameObject Achivobject;
    public Transform leaderboardcontent;
    public Transform achivcontent;
    private void Awake()
    {
        AchievementsSystem.LoadAchievements();
    }

    private void Start()
    {
        data = SaveSystem.LoadData();
        StartCoroutine(SaveSystem.PostScores(data));

        AchievementsSystem.AddProgress(0);
        AchievementsSystem.SaveAchievements();

        highscoredisplay.text = $"Seus maiores pontos:\n {data.points}";

        UpdateLeaderboard();
        UpdateAchivs();
       
    }

    public void StartGame()
    {
        SceneManager.LoadScene(1);
    }
    public void ExitGame()
    {
        AchievementsSystem.SaveAchievements();
        Application.Quit();
    }
    void UpdateLeaderboard()
    {
        StartCoroutine(SaveSystem.GetScores(this));
    }
    void UpdateAchivs()
    {
        foreach(Achievement ac in AchievementsSystem.Achievements)
        {
            bool completed = ac.currectProgress >= ac.MaxProgress;

            Debug.Log($"Achiv:{ac.title} : {ac.currectProgress}/{ac.MaxProgress}");

            GameObject c = Instantiate(Achivobject, achivcontent);

            c.transform.Find("IsLock").gameObject.SetActive(!completed);

            TMP_Text title = c.transform.Find("Title").Find("Text").GetComponent<TMP_Text>();
            TMP_Text desc = c.transform.Find("Desc").GetComponent<TMP_Text>();

            title.text = ac.title;
            desc.text = ac.desc;

        }
    }
    public void AddP(int le,string Name,int points)
    {
        GameObject pil = Instantiate(personinleader, leaderboardcontent);
        pil.transform.SetSiblingIndex(le);
        pil.GetComponentInChildren<TMP_Text>().text = $"#{le + 1} {Name} - {points}";
    }


}
