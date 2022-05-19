using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Cat : MonoBehaviour
{

    private Animator animator;

    public float Hungry;
    private static float MaxH = 20,MinH = 5;
    public bool HasFood = false;


    void Start()
    {
        GameManager.manager.OnStateChanged += GameChangeState;
        animator = GetComponent<Animator>();
        Hungry = MaxH;
        enabled = GameManager.manager.gameState == GameState.Gameplay;
    }

    void Update()
    {
        animator.SetBool("Hungry", Hungry <= MinH);

        if(HasFood && Hungry <= MinH)
        {
            Hungry = MaxH;
            animator.SetTrigger("Eat");
        }
        else if(Hungry < 0)
        {
            //Lose Game or lose points per update
            Debug.Log("Gato Morreu");
        }
    }

    private void FixedUpdate()
    {
        Hungry -= Time.deltaTime;
    }

    private void OnMouseDown()
    {
        if (Hungry > MinH) return;
        if (!HasFood)
        {
            GameManager.manager.AddPoints(50);
            HasFood = true;
        }
            
    }

    public void GameChangeState(GameState newGameState)
    {
        enabled = newGameState == GameState.Gameplay;
    }
}
