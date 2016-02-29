/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016. Diorite (by Bartłomiej Mazur (aka GotoFinal))
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package org.diorite.impl.inventory.recipe;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import org.diorite.impl.inventory.recipe.craft.CraftingRecipeBuilderImpl;
import org.diorite.inventory.GridInventory;
import org.diorite.inventory.item.ItemStack;
import org.diorite.inventory.recipe.craft.CraftingRecipe;
import org.diorite.inventory.recipe.craft.CraftingRecipeBuilder;
import org.diorite.inventory.recipe.craft.CraftingRecipeCheckResult;
import org.diorite.inventory.recipe.craft.CraftingRecipeGroup;

public class RecipeManagerImpl implements IRecipeManager
{
    private final Set<CraftingRecipe> recipes = new TreeSet<>(RecipeComparator.INSTANCE);

    @Override
    public CraftingRecipeBuilder craftingBuilder()
    {
        return new CraftingRecipeBuilderImpl();
    }

    @Override
    public boolean add(final CraftingRecipe recipe)
    {
        return this.recipes.add(recipe);
    }

    @Override
    public boolean remove(final CraftingRecipe recipe)
    {
        return this.recipes.remove(recipe);
    }

    @Override
    public Iterator<? extends CraftingRecipe> recipeIterator()
    {
        return this.recipes.iterator();
    }

    @Override
    public void resetCraftingRecipes()
    {
        this.clearCraftingRecipes();
        this.addDefaultCraftingRecipes();
    }

    @Override
    public void clearCraftingRecipes()
    {
        this.recipes.clear();
    }

    @Override
    public Iterator<CraftingRecipe> craftingRecipeIterator()
    {
        final Iterator<CraftingRecipe> it = this.recipes.iterator();
        return new CraftingRecipeIterator(it);
    }

    @Override
    public CraftingRecipeCheckResult matchCraftingRecipe(final GridInventory grid)
    {
        for (final CraftingRecipe recipe : this.recipes)
        {
            final CraftingRecipeCheckResult result = recipe.isMatching(grid);
            if (result != null)
            {
                return result;
            }
        }
        return null;
    }

    private static volatile int i = 0;

    @Override
    public void reset()
    {
        this.clear();
        this.addDefaultRecipes();
    }

    @Override
    public void clear()
    {
        this.clearCraftingRecipes();
    }

    @Override
    public CraftingRecipeCheckResult isMatching(final GridInventory inventory)
    {
        throw new IllegalStateException("isMatching method used on root recipe manager.");
    }

    @Override
    public List<ItemStack> getResult()
    {
        throw new IllegalStateException("getResult method used on root recipe manager.");
    }

    @Override
    public long getPriority()
    {
        throw new IllegalStateException("getPriority method used on root recipe manager.");
    }

    @Override
    public boolean isVanilla()
    {
        throw new IllegalStateException("isVanilla method used on root recipe manager.");
    }

    private static long getNextPriority()
    {
        return CraftingRecipe.DIORITE_START + ((2 * (i++)) * CraftingRecipe.DIORITE_SPACE);
    }

    @Override
    public void addDefaultCraftingRecipes()
    {
// TODO
    }

    @Override
    public String toString()
    {
        return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("recipes", this.recipes).toString();
    }

    private static class CraftingRecipeIterator implements Iterator<CraftingRecipe>
    {
        private final Iterator<? extends CraftingRecipe> it;
        private       CraftingRecipeIterator             it2;
        private int nextWithoutRemove = - 1;

        private CraftingRecipeIterator(final Iterator<? extends CraftingRecipe> it)
        {
            this.it = it;
        }

        @Override
        public boolean hasNext()
        {
            if (this.it2 != null)
            {
                if (this.it2.hasNext())
                {
                    return true;
                }
                this.nextWithoutRemove = - 1;
                this.it2 = null;
            }
            return this.it.hasNext();
        }

        @Override
        public CraftingRecipe next()
        {
            if (this.it2 != null)
            {
                if (this.it2.hasNext())
                {
                    this.nextWithoutRemove++;
                    return this.it2.next();
                }
                this.nextWithoutRemove = - 1;
                this.it2 = null;
            }
            final CraftingRecipe recipe = this.it.next();
            if (recipe instanceof CraftingRecipeGroup)
            {
                this.it2 = new CraftingRecipeIterator(((CraftingRecipeGroup) recipe).recipeIterator());
                return this.next();
            }
            return recipe;
        }

        @Override
        public void remove()
        {
            if (this.it2 != null)
            {
                this.it2.remove();
                final boolean rem = this.nextWithoutRemove == 0;
                if (rem)
                {
                    this.nextWithoutRemove = - 1;
                }
                if (! this.it2.hasNext())
                {
                    this.it2 = null;
                    this.nextWithoutRemove = - 1;
                    if (rem)
                    {
                        this.it.remove();
                    }
                }
                return;
            }
            this.it.remove();
        }

        @Override
        public String toString()
        {
            return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE).appendSuper(super.toString()).append("it", this.it).toString();
        }
    }
}
