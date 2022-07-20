//import logo from './logo.svg';
/* import { useCallback, useState, useRef } from 'react';
import './App.css';
import TodoInsert from './uicom/TodoInsert';
import TodoList from './uicom/TodoList';
import TodoTemplate from './uicom/TodoTemplate';

const createTodoDatas = () => {
  const arr = [];
  for (let i = 1; i <= 2500; i++) {
    arr.push({ id: i, text: `리액트 할일 예제 ${i}`, checked: false });
  }
  return arr;
};

function App() {
  const [todos, setTodos] = useState(createTodoDatas);
  const nextId = useRef(2501);
  const onInsert = useCallback(
    (text) => {
      const todo = {
        id: nextId.current,
        text,
        checked: false,
      };

      setTodos((todos) => todos.concat(todo));
      nextId.current += 1;
    },
    [todos],
  );
  const onRemove = useCallback(
    (id) => {
      setTodos((todos) =>
        todos.filter((todo) => {
          return id !== todo.id;
        }),
      );
    },
    [todos],
  );
  const onToggle = useCallback(
    (id) => {
      setTodos((todos) =>
        todos.map((todo) => {
          return todo.id === id ? { ...todo, checked: !todo.checked } : todo;
        }),
      );
    },
    [todos],
  );

  return (
    <>
      <TodoTemplate>
        <TodoInsert onInsert={onInsert}></TodoInsert>
        <TodoList todos={todos} onRemove={onRemove} onToggle={onToggle} />
      </TodoTemplate>
    </>
  );
}

export default App; */
import { useCallback, useState, useRef, useReducer } from 'react';
import './App.css';
import TodoInsert from './uicom/TodoInsert';
import TodoList from './uicom/TodoList';
import TodoTemplate from './uicom/TodoTemplate';

const createTodoDatas = () => {
  const arr = [];
  for (let i = 1; i <= 2500; i++) {
    arr.push({ id: i, text: `리액트 할일 예제 ${i}`, checked: false });
  }
  return arr;
};

const todoReducer = (todos, action) => {
  switch (action.type) {
    case 'INSERT':
      return todos.concat(action.todo);
    case 'REMOVE':
      return todos.filter((todo) => {
        return action.id !== todo.id;
      });
    case 'TOGGLE':
      return todos.map((todo) => {
        return todo.id === action.id
          ? { ...todo, checked: !todo.checked }
          : todo;
      });
    default:
      return todos;
  }
};

function App() {
  const [todos, dispatch] = useReducer(
    todoReducer, // 실행 리듀서함수
    undefined, // 초기치
    createTodoDatas, // 초기치 생성함수
  );

  const nextId = useRef(2501);
  const onInsert = useCallback((text) => {
    const todo = {
      id: nextId.current,
      text,
      checked: false,
    };

    dispatch({
      type: 'INSERT',
      todo,
    });
    nextId.current += 1;
  }, []);
  const onRemove = useCallback((id) => {
    dispatch({ type: 'REMOVE', id });
  }, []);
  const onToggle = useCallback((id) => {
    dispatch({ type: 'TOGGLE', id });
  }, []);

  return (
    <>
      <TodoTemplate>
        <TodoInsert onInsert={onInsert}></TodoInsert>
        <TodoList todos={todos} onRemove={onRemove} onToggle={onToggle} />
      </TodoTemplate>
    </>
  );
}

export default App;
