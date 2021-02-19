package main

import (
	"fmt"
)

//BinaryTree is a struct that models a BinaryTree.
type BinaryTree struct {
	occupancy int
	capacity  int
	depth     int
	data      []*Integer
}

//Integer is the node type of the binary tree. If we wanted to use generics,
// we could make data an interface{}
type Integer struct {
	value int
}

//IntPow2 raises an integer to the power of 2 using bitshifting. Gos default func in math returns a float64,
//so I made this function as a quick replacement
func IntPow2(powerToRaise int) int {
	base := 1
	base = base << powerToRaise

	return base
}

/*BinaryTreeFactory is a factory method for building a binary tree with a capacity of one.
  If more than one element needs to be added, the tree is able to grow dynamically.
*/
func BinaryTreeFactory() *BinaryTree {
	return &BinaryTree{0, 1, 0, make([]*Integer, 1)}
}

/*toString prints out a binarytree
 */
func (tree *BinaryTree) toString() {

	formatLine := "***********************************************************************************************************"
	fmt.Println("Binary Tree Summary")
	fmt.Println("Capacity defines the maximum number of elements the tree can hold. A tree's capacity can grow dynamically")
	fmt.Println("Occupancy defines the number of occupants in the tree.")
	fmt.Println("Depth defines the number of levels in the tree. A tree with a depth of 0 represents a tree with just a root.")
	fmt.Println(formatLine)
	fmt.Printf("Capacity: %d \n", tree.capacity)
	fmt.Printf("Occupancy: %d \n", tree.occupancy)
	fmt.Printf("Current Depth: %d \n", tree.depth)
	fmt.Println(formatLine)
	fmt.Println("PRINTING YOUR TREE")
	tree.printSelf()
}

func (tree *BinaryTree) printSelf() {
	curDepth := 1
	previousLevelStart := 1
	nextLevelStart := 3
	var treeData *Integer = nil

	if tree.occupancy != 0 {
		//print root
		fmt.Printf(" %d ", tree.data[0].value)
		for curDepth <= tree.depth {
			curIterator := previousLevelStart
			nextLevelStart = IntPow2(curDepth) + previousLevelStart
			fmt.Println() // make newline to separate levels

			for curIterator < nextLevelStart {
				treeData = tree.data[curIterator]

				if treeData == nil {
					fmt.Printf(" %c ", 'x')
				} else {
					fmt.Printf(" %d ", treeData.value)
				}
				curIterator++
			}

			previousLevelStart = nextLevelStart
			curDepth++
		}
	} else {
		fmt.Printf("Empty Tree. There's nothing to print.")
	}

}

func (tree *BinaryTree) increaseCapacity() {
	tree.depth++
	newTreeSliceSize := IntPow2(tree.depth) + tree.capacity // new size old size + old size doubled (this equals 2^incremented depth on line 90)
	newCapacitySlice := make([]*Integer, newTreeSliceSize)

	tree.copyDataIntoExpandedSlice(newCapacitySlice) //copy old values into new expanded slice
	tree.capacity = newTreeSliceSize                 //incr nextlevel since we have just expanded the tree
}

/*
	copyDataIntoExpandedSlice is used to copy the contents of a binary tree whenever a tree needs
	to expand. This usually happens when the user adds an element to a tree at full capacity.
*/
func (tree *BinaryTree) copyDataIntoExpandedSlice(newTreeSlice []*Integer) {
	oldTreeLen := len(tree.data)

	for oldTreeIterator := 0; oldTreeIterator < oldTreeLen; oldTreeIterator++ {
		newTreeSlice[oldTreeIterator] = tree.data[oldTreeIterator]
	}

	tree.data = newTreeSlice
}
func (tree *BinaryTree) AddElement(elementToAdd int) bool {

	newElement := &Integer{elementToAdd}

	//check if larger array is needed, and if so make it
	if tree.capacity == tree.occupancy {
		tree.increaseCapacity()
	}
	//add new element in tree
	tree.data[tree.occupancy] = newElement
	tree.occupancy++ //add new element

	return true
}

func (tree *BinaryTree) RemoveElement(elementToRemove int) bool {
	treeIterator := 0
	treeData := tree.data
	elementRemoved := false

	//if the tree is not empty,a ttempt to find elementToRemove and remove it while retaining a balanced binary tree
	//with no holes or gaps
	if tree.occupancy != 0 {
		// only continue the while loop if the element has not been removed AND we have not reached the end of the tree
		for !elementRemoved && treeIterator < tree.occupancy {
			if treeData[treeIterator].value == elementToRemove {
				//Most removals will occur with a size greater than one so check for it first
				if tree.occupancy != 1 {
					// tree.occupancy is zero indexed, so the final element is in position tree.occupancy -1
					if treeIterator != (tree.occupancy - 1) {
						swapBuffer := tree.data[tree.occupancy-1] //get last element in tree
						tree.data[treeIterator] = swapBuffer      // place it in the spot of the removed element
						tree.data[tree.occupancy-1] = nil         // remove old pointer since it has moved up the tree
						tree.occupancy--                          //occupant removed. reduce occupancy by 1
						elementRemoved = true
					} else {
						treeData[treeIterator] = nil // the item we wish to remove is at the end of the tree set it to nil.
						tree.occupancy--
						elementRemoved = true
					}

				} else {
					tree.data[0] = nil
				}
			}
			treeIterator++
		}
	}
	return true
}

func main() {

	tree := BinaryTreeFactory()
	tree.AddElement(1)

	tree.AddElement(2)
	tree.AddElement(3)

	tree.AddElement(4)
	tree.AddElement(5)
	tree.AddElement(6)
	tree.AddElement(7)

	tree.AddElement(8)
	tree.AddElement(9)
	tree.AddElement(10)
	tree.AddElement(11)
	tree.AddElement(12)
	tree.AddElement(13)
	tree.AddElement(14)
	tree.AddElement(15)

	tree.AddElement(16)
	tree.AddElement(17)
	tree.AddElement(18)
	tree.RemoveElement(5)

	tree.toString()

}
