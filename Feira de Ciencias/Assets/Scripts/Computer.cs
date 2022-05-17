﻿using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
public class Computer : MonoBehaviour
{
    public bool isBronken;
    public ParticleSystem smoke;
    public SpriteRenderer monitor;
    public TextMeshPro displaytxt;
    public Sprite workingsprite, bronkesprite;

    public static KeyCode[] keys = new KeyCode[]
    {
        KeyCode.A,
        KeyCode.W,
        KeyCode.S,
        KeyCode.D
    };

    public KeyCode currectkey;

    public int life;

    private void Start()
    {
        newkey();
        life = 200;
    }

    void newkey()
    {
        currectkey = keys[Random.Range(0, keys.Length - 1)];
    }

    void Update()
    {
        monitor.sprite = isBronken ? bronkesprite : workingsprite;
        displaytxt.gameObject.SetActive(!isBronken);

        

        if (isBronken)
        {
            if (!smoke.isPlaying) smoke.Play();
            if (Input.GetKeyDown(KeyCode.Space))
            {
                GameManager.manager.AddPoints(5);
                life += 5;
                GetComponent<Animator>().Play("Fix", 0);
            }
            if (life >= 200) isBronken = false;
        }
        else
        {
            if (smoke.isPlaying) smoke.Stop();
            if (life <= 0) isBronken = true;
            displaytxt.text = currectkey.ToString();
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
                        life -= 10;
                        GetComponent<Animator>().Play("Error", 0);
                        GameManager.manager.AddPoints(-100);
                    }
                }
            }
        }
    }
}