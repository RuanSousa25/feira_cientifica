using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class Cat : MonoBehaviour
{

    private Animator animator;

    public float Hungry;
    private static float MaxH = 10,MinH = 5;
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
            HasFood = false;
            animator.SetTrigger("Eat");
        }
        else if(Hungry < 0)
        {
            GameManager.manager.Lose("Você nao alimentou seu gato");
        }
    }

    private void FixedUpdate()
    {
        Hungry -= Time.deltaTime * Random.Range(0f,1f);
    }

    private void OnMouseDown()
    {
        if (Hungry > MinH) return;
        if (!HasFood)
        {

            AchievementsSystem.AddProgress(9);
            AchievementsSystem.AddProgress(10);
            AchievementsSystem.AddProgress(11);
            AchievementsSystem.AddProgress(12);
            GameManager.manager.AddPoints(50);
            if(Hungry <= 1)
            {
                AchievementsSystem.AddProgress(3);
            }
            HasFood = true;
        }
            
    }

    public void GameChangeState(GameState newGameState)
    {
        enabled = newGameState == GameState.Gameplay;
    }
}
