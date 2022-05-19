using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
public class HudController : MonoBehaviour
{
    public TMP_Text PointsDisplay;

    private void Update()
    {
        PointsDisplay.text = GameManager.manager.Points.ToString();
    }
}
