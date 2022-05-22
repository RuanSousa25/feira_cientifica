using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;
public class HudController : MonoBehaviour
{
    public TMP_Text PointsDisplay;
    public TMP_Text TimerDisplay;
    private void Update()
    {
        PointsDisplay.text = GameManager.manager.Points.ToString();
        TimerDisplay.text = Mathf.RoundToInt(GameManager.manager.timeleft).ToString() + "s";
    }

    public void ReturnToMenu()
    {
        UnityEngine.SceneManagement.SceneManager.LoadScene(0);
    }
}
