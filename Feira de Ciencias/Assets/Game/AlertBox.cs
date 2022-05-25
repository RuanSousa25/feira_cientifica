using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class AlertBox : MonoBehaviour
{
    public static AlertBox instance;
    private Animation anim;
    public TMPro.TMP_Text text;
    private void Awake()
    {
        if (instance != null)
        {
            if (instance != this)
            {
                Destroy(this.gameObject);
            }
        }
        else
        {
            instance = this;
        }
    }

    private void Start()
    {
        anim = GetComponent<Animation>();
    }

    public void SendWarn(string message)
    {
        anim.Play();
        text.text = message;
    }

}
