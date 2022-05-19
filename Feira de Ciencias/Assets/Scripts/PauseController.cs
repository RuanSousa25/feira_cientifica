using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class PauseController : MonoBehaviour
{

    private GameState previusState;

    public void Pause()
    {
        previusState = GameManager.manager.gameState;
        GameManager.manager.SetState(GameState.Paused);
    }
    public void Resume()
    {
        GameManager.manager.SetState(previusState);
    }
}
