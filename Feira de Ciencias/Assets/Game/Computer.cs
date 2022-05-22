using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
public class Computer : MonoBehaviour
{
    public bool isBronken;
    public ParticleSystem smoke;
    public SpriteRenderer monitor;
    public TextMeshPro displaytxt;
    public TextMeshPro nextdisplaytxt;
    public Sprite workingsprite, bronkesprite;

    public static KeyCode[] keys = new KeyCode[]
    {
        KeyCode.A,
        KeyCode.W,
        KeyCode.S,
        KeyCode.D
    };
    public KeyCode nextkey;
    public KeyCode currectkey;

    public int life;

    private void Start()
    {
        nextkey = keys[Random.Range(0, keys.Length)];
        newkey();
        life = 5;
        GameManager.manager.OnStateChanged += GameChangeState;

        enabled = GameManager.manager.gameState == GameState.Gameplay;
    }

    void newkey()
    {
        currectkey = nextkey;
        nextkey = keys[Random.Range(0, keys.Length)];
    }

    void Update()
    {
        monitor.sprite = isBronken ? bronkesprite : workingsprite;
        displaytxt.gameObject.SetActive(!isBronken);

        

        if (isBronken)
        {
            if (!smoke.isPlaying) smoke.Play(true);
            if (Input.GetKeyDown(KeyCode.Space))
            {
                GameManager.manager.AddPoints(5);
                life += 1;
                GetComponent<Animator>().Play("Fix", 0);
            }
            if (life == 5) isBronken = false;
        }
        else
        {
            if (smoke.isPlaying) smoke.Stop(true);
            if (life <= 0) isBronken = true;
            displaytxt.text = currectkey.ToString();
            nextdisplaytxt.text = nextkey.ToString();
            foreach (KeyCode k in keys)
            {
                if(Input.GetKeyDown(k))
                {
                    if (k == currectkey)
                    {
                        newkey();
                        GameManager.manager.AddPoints(200);
                    }
                    else
                    {
                        life -= 1;
                        GetComponent<Animator>().Play("Error", 0);
                        GameManager.manager.AddPoints(-100);
                    }
                }
            }
        }
    }

    public void GameChangeState(GameState newGameState)
    {
        enabled = newGameState == GameState.Gameplay;
    }
}
