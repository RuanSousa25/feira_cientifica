using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.SceneManagement;
using TMPro;

public class MenuManager : MonoBehaviour
{

    public TMP_Text highscoredisplay;
    private SaveData data;

    public GameObject personinleader;
    public Transform leaderboardcontent;

    private void Start()
    {
        data = SaveSystem.LoadData();
        if(Application.internetReachability != NetworkReachability.NotReachable)
        {
            StartCoroutine(SaveSystem.PostScores(data));
        }

        highscoredisplay.text = $"Seus maiores pontos:\n {data.points}";

        UpdateLeaderboard();
       
    }

    public void StartGame()
    {
        SceneManager.LoadScene(1);
    }

    void UpdateLeaderboard()
    {
        StartCoroutine(SaveSystem.GetScores(this));
    }
    public void AddP(int le,string Name,int points)
    {
        GameObject pil = Instantiate(personinleader, leaderboardcontent);
        pil.transform.SetSiblingIndex(le);
        pil.GetComponentInChildren<TMP_Text>().text = $"#{le + 1} {Name} - {points}";
    }
}
