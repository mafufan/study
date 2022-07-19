import React from 'react';
import './TodoList.scss';
import TodoListItem from './TodoListItem';

const TodoList = ({ todos, onRemove, onToggle }) => {
  return (
    <>
      <div className="TodoList">
        {todos.map(todo => {
          return (
            <TodoListItem
              key={todo.id}
              todo={todo}
              onRemove={onRemove}
              onToggle={onToggle}
            ></TodoListItem>
          );
        })}
      </div>
    </>
  );
};

export default TodoList;
