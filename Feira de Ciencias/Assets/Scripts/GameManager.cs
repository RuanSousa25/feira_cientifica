using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class GameManager : MonoBehaviour
{
    public static GameManager manager;

    public int Points;

    private void Awake()
    {
        if(manager == null)
        {
            manager = this;
        }else if(manager != this)
        {
            Destroy(gameObject);
        }
    }

    public void AddPoints(int amount)
    {
        Points += amount;
    }


}
