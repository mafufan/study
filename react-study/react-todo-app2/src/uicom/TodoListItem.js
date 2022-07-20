import React from 'react';
import {
  MdCheckBoxOutlineBlank,
  MdCheckBox,
  MdRemoveCircleOutline,
} from 'react-icons/md';
import './TodoListItem.scss';
import cn from 'classnames';

const TodoListItem = (props) => {
  const { todo, onRemove, onToggle, style } = props;
  const { id, text, checked } = todo;
  return (
    <>
      <div className="TodoListItem-virtualized" style={style}>
        <div className="TodoListItem" style={style}>
          <div
            className={cn('checkbox', { checked })}
            onClick={(e) => {
              onToggle(id);
            }}
          >
            {checked ? <MdCheckBox /> : <MdCheckBoxOutlineBlank />}
            <div className="text"> {text} </div>
          </div>

          <div
            className="remove"
            onClick={(e) => {
              onRemove(id);
            }}
          >
            <MdRemoveCircleOutline />
          </div>
        </div>
      </div>
    </>
  );
};

// export default TodoListItem;
export default React.memo(TodoListItem);
