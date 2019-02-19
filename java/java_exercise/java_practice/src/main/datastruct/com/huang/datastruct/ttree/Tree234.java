package com.huang.datastruct.ttree;
public class Tree234
 {
    
private
 
Node2
 root = 
new
 
Node2
();
    
public
 
int
 find(
long
 key) {
        
Node2
 currentNode = root;
        
int
 childNumber;
        
while
(
true
) {
            
if
((childNumber = currentNode.findItem(key)) != -
1
) {
                
return
 childNumber;
            }
            
else
 
if
(currentNode.isLeaf()) {
                
return
 -
1
;
            }
            
else
 {
                currentNode = getNextChild(currentNode, key);
            }
        }
    }
    
//insert a DataItem
    
public
 
void
 insert(
long
 data) {
        
Node2
 currentNode = root;
        
DataItem
 tempItem = 
new
 
DataItem
(data);
        
while
(
true
) {
            
if
(currentNode.isFull()) {
                split(currentNode); 
//if node is full, split it
                currentNode = currentNode.getParent();  
//back up
                currentNode = getNextChild(currentNode, data);  
//search once
            }
            
else
 
if
(currentNode.isLeaf()) { 
//if node if leaf
                
break
;  
//go insert
            }
            
else
 {
                currentNode = getNextChild(currentNode, data);
            }
        }
        currentNode.insertItem(tempItem);
    }
    
//display tree
    
public
 
void
 displayTree() {
        recDisplayTree(root, 
0
, 
0
);
    }
    
public
 
Node2
 getNextChild(
Node2
 currentNode, 
long
 key) {
        
int
 j;
        
//assumes node is not empty, not full and not leaf
        
int
 numItems = currentNode.getNumItems();
        
for
(j = 
0
; j < numItems; j++) {
            
if
(key < currentNode.getItem(j).dData) {
                
return
 currentNode.getChild(j);
            }
        }
        
return
 currentNode.getChild(j);
    }
    
public
 
void
 split(
Node2
 currentNode) {
        
//assumes node is full
        
DataItem
 itemB, itemC;  
//存储要分裂节点的后两个DataItem
        
Node2
 parent, child2, child3;   
//存储要分裂节点的父节点和后两个child
        
int
 itemIndex;
        itemC = currentNode.removeItem();
        itemB = currentNode.removeItem();   
//remove items from this node
        child2 = currentNode.disconnectChild(
2
);
        child3 = currentNode.disconnectChild(
3
); 
//remove children from this node
        
Node2
 newRight = 
new
 
Node2
(); 
//make a new node
        
if
(currentNode == root) {
            root = 
new
 
Node2
(); 
//make a new root
            parent = root;  
//root is our parent
            root.connectChild(
0
, currentNode);
//connect currentNode to parent
        }
        
else
 {
            parent = currentNode.getParent();
        }
        
//deal with parent
        itemIndex = parent.insertItem(itemB);   
//insert B to parent
        
int
 n = parent.getNumItems();   
//total items
        
for
(
int
 j = n-
1
; j > itemIndex; j--) {
            
Node2
 temp = parent.disconnectChild(j);
            parent.connectChild(j+
1
, temp);
        }
        parent.connectChild(itemIndex+
1
, newRight);
        
//deal with newRight
        newRight.insertItem(itemC);
        newRight.connectChild(
0
, child2);
        newRight.connectChild(
1
, child3);
    }
    
public
 
void
 recDisplayTree(
Node2
 thisNode, 
int
 level, 
int
 childNumber) {
        
System
.out.print(
"level = "
 + level + 
" child = "
 + childNumber + 
" "
);
        thisNode.displayNode();
        
//call ourselves for each child of this node
        
int
 numItems = thisNode.getNumItems();
        
for
(
int
 j = 
0
; j < numItems+
1
; j++) {
            
Node2
 nextNode = thisNode.getChild(j);
            
if
(nextNode != 
null
) {
                recDisplayTree(nextNode, level+
1
, j);
            }
            
else
 
                
continue
;
        }
    }
}
//数据项
class
 
DataItem
 {
    
public
 
long
 dData;
    
public
 
DataItem
(
long
 data) {
        dData = data;
    }
    
public
 
void
 displayItem() {
        
System
.out.print(
"/"
 + dData);
    }
}
//节点
class
 
Node2
 {
    
private
 
static
 
final
 
int
 ORDER = 
4
;
    
private
 
int
 numItems; 
//表示该节点存有多少个数据项
    
private
 
Node2
 parent;
    
private
 
Node2
 childArray[] = 
new
 
Node2
[ORDER]; 
//存储子节点的数组，最多四个子节点
    
private
 
DataItem
 itemArray[] = 
new
 
DataItem
[ORDER-
1
];
//该节点中存放数据项的数组，每个节点最多存放三个数据项
    
//连接子节点
    
public
 
void
 connectChild(
int
 childNum, 
Node2
 child) {
        childArray[childNum] = child;
        
if
(child != 
null
) {
            child.parent = 
this
;
        }
    }
    
//断开与子节点的连接，并返回该子节点
    
public
 
Node2
 disconnectChild(
int
 childNum) {
        
Node2
 tempNode = childArray[childNum];
        childArray[childNum] = 
null
;
        
return
 tempNode;
    }
    
public
 
Node2
 getChild(
int
 childNum) {
        
return
 childArray[childNum];
    }
    
public
 
Node2
 getParent() {
        
return
 parent;
    }
    
public
 
boolean
 isLeaf() {
        
return
 (childArray[
0
] == 
null
);
    }
    
public
 
int
 getNumItems() {
        
return
 numItems;
    }
    
public
 
DataItem
 getItem(
int
 index) {
        
return
 itemArray[index];
    }
    
public
 
boolean
 isFull() {
        
return
 (numItems == ORDER-
1
);
    }
    
public
 
int
 findItem(
long
 key) {
        
for
(
int
 j = 
0
; j < ORDER-
1
; j++) {
            
if
(itemArray[j] == 
null
) {
                
break
;
            }
            
else
 
if
(itemArray[j].dData == key) {
                
return
 j;
            }
        }
        
return
 -
1
;
    }
    
public
 
int
 insertItem(
DataItem
 newItem) {
        
//assumes node is not full
        numItems++;
        
long
 newKey = newItem.dData;
        
for
(
int
 j = ORDER-
2
; j >= 
0
; j--) {     
//start on right
            
if
(itemArray[j] == 
null
) {      
//item is null
                
continue
;                   
//get left one cell
            }
            
else
 {                          
//not null
                
long
 itsKey = itemArray[j].dData;   
//get its key
                
if
(newKey < itsKey) {               
//if it's bigger
                    itemArray[j+
1
] = itemArray[j];  
//shift it right
                }
                
else
 {
                    itemArray[j+
1
] = newItem;       
//insert new item
                    
return
 j+
1
;                     
//return index to new item
                }
            }
        }
        itemArray[
0
] = newItem;
        
return
 
0
;
    }
    
public
 
DataItem
 removeItem() {
        
//assumes node not empty
        
DataItem
 tempItem = itemArray[numItems-
1
];  
//save item
        itemArray[numItems-
1
] = 
null
;               
//disconnect it
        numItems--;
        
return
 tempItem;
    }
    
public
 
void
 displayNode() {
        
for
(
int
 i = 
0
; i < numItems; i++) {
            itemArray[i].displayItem();
        }
        
System
.out.println(
"/"
);
    }
}