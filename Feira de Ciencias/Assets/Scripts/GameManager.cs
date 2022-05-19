using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public enum GameState
{
    Starting = 0,Gameplay,Paused,Ending
}

public class GameManager : MonoBehaviour
{
    public static GameManager manager;

    public int Points;
    public GameObject StartingGame;
    public TMP_Text txt;
    public GameObject floatingText;

    public float timeleft;

    public GameState gameState { get; private set; }

    public delegate void StateChangeHandler(GameState newGameState);
    public event StateChangeHandler OnStateChanged;


    IEnumerator StartMessage(string msg)
    {
        StartingGame.SetActive(true);
        txt.text = "";
        foreach(char c in msg)
        {
            txt.text += c;
            yield return new WaitForSeconds(.05f);
            yield return new WaitWhile(() => gameState == GameState.Paused);
        }
        for(int i = 0;i < 5; i++)
        {
            yield return new WaitWhile(() => gameState == GameState.Paused);
            yield return new WaitForSeconds(1f);
        }
        StartingGame.SetActive(false);
        SetState(GameState.Gameplay);
    }

    /*
    IEnumerator EndMessage(string msg)
    {

    }
    */
    private void Awake()
    {
        if(manager == null)
        {
            manager = this;
        }else if(manager != this)
        {
            Destroy(gameObject);
        }

        timeleft = 60;
    }

    private void Start()
    {
        manager.SetState(GameState.Starting);
        StartCoroutine(StartMessage("Você tem apenas um minuto."));
    }

    private void FixedUpdate()
    {
        if (gameState == GameState.Gameplay)
        {
            timeleft -= Time.deltaTime;
            if(timeleft <= 0)
            {
                SetState(GameState.Ending);
            }
        }
            
    }

    public void SetState(GameState newstate)
    {
        if (gameState == newstate) return;

        gameState = newstate;
        OnStateChanged?.Invoke(newstate);
    }

    public void AddPoints(int amount)
    {
        TextMeshPro ft = Instantiate(floatingText).GetComponent<TextMeshPro>();
        ft.text = amount > 0 ? "+" + amount : amount.ToString();
        ft.color = amount > 0 ? Color.green : Color.red;
        Points += amount;

        Destroy(ft.gameObject, 1.5f);
    }


}
