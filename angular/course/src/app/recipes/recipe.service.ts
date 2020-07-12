import { EventEmitter, Injectable } from '@angular/core';
import { Recipe } from './recipe.model';
import { Ingredient } from '../shared/ingredient.model';
import { ShoppingListService } from '../shopping-list/shopping-list.service';

@Injectable()
export class RecipeService{

    recipeSelected = new EventEmitter<Recipe>();

    private recipes: Recipe[] = [
        new Recipe('Butter Nan' , 
        'India bread with butter' , 
        'https://upload.wikimedia.org/wikipedia/commons/3/35/Butter_Garlic_Naan.jpg',
        [
        new Ingredient('butter' ,1),
        new Ingredient('flour' ,1),
        ]),
        new Recipe('Chicken Tikka Roll' , 
        'India bread with Chiken Tikka' , 
        'https://live.staticflickr.com/3614/3524375270_88f94389fe_z.jpg',
        [
        new Ingredient('chicken' ,1),
        new Ingredient('Tortila' ,1),
        ])
      ];

constructor(private slService: ShoppingListService){}

      getRecipes(){
          return this.recipes.slice();
      }

      getRecipe(index: number){
        return this.recipes[index];
      }

      addIngredientsToShoppingList(ingredients: Ingredient[]){
        this.slService.addIngredients(ingredients);
      }
}