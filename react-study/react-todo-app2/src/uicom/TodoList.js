import React, { useCallback } from 'react';
import TodoListItem from './TodoListItem';
import { List } from 'react-virtualized';
import './TodoList.scss';

const TodoList = ({ todos, onRemove, onToggle }) => {
  const listItemRenderFn = useCallback(
    ({ index, key, style }) => {
      const todo = todos[index];
      return (
        <TodoListItem
          todo={todo}
          key={key}
          onRemove={onRemove}
          onToggle={onToggle}
          style={style}
        />
      );
    },
    [todos, onRemove, onToggle],
  );
  return (
    <>
      <List
        className="TodoList"
        width={512}
        height={513}
        rowCount={todos.length}
        rowHeight={57}
        rowRenderer={listItemRenderFn}
        list={todos}
        style={{ outline: 'none' }}
      ></List>
      {/* <div className="TodoList">
        {todos.map((todo) => {
          return (
            <TodoListItem
              todo={todo}
              key={todo.id}
              onRemove={onRemove}
              onToggle={onToggle}
            />
          );
        })}
      </div> */}
    </>
  );
};

export default React.memo(TodoList);
