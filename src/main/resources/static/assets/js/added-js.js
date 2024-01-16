/*table resizable*/
document.addEventListener('DOMContentLoaded', function() {
    let tables = document.querySelectorAll('.resizableTable');
    let isResizing = false;
    let currentResizer;
    let currentPositionX;
    let currentIndex;
    let currentTable;

    let cols = document.querySelectorAll('.resizableTable col');

    cols.forEach(function(col) {
    let computedWidth = window.getComputedStyle(col).width;
    col.style.width = computedWidth;
    });

    tables.forEach((table,index) => {
    let resizers = table.querySelectorAll('thead tr th');
    resizers.forEach(resizer => {
    resizer.addEventListener('mousedown', handleMouseDown);
    });
    console.log("table:"+index);
    });
    document.addEventListener('mousemove', handleMouseMove);
    document.addEventListener('mouseup', handleMouseUp);

    function handleMouseDown(e) {
        isResizing = true;
        currentResizer = e.target;
        currentPositionX = currentResizer.getBoundingClientRect().left;
        let thElements = Array.from(currentResizer.parentElement.children);
        currentIndex = thElements.indexOf(currentResizer);
        currentTable = currentResizer.parentElement.parentElement.parentElement;
    }

    function handleMouseMove(e) {
        if (isResizing) {
            // col 요소 선택
            let colElement = currentTable.querySelector('colgroup col:nth-child(' + (currentIndex + 1) + ')');
            let newWidth = e.clientX - currentPositionX;
            // 새로운 너비 적용
            colElement.setAttribute('style', 'width:' + newWidth + 'px');
        }
    }

    function handleMouseUp() {
        isResizing = false;
        currentResizer = null;
    }
});
/*table resizable end*/

/*table row select*/
/*product-list-table select*/
$('.selectableTable tbody tr td').click(function() {
      var row = $(this).parent();
      var rowIndex = row.index();
      console.log("row:"+row);
      console.log("rowIndex:"+rowIndex);
      row.find('td').toggleClass('selectableTable-selected');
    });
/*table row select end*/
$('.selectableTable tbody tr td').hover(
  function() {
    var row = $(this).parent();
    row.find('td').addClass('selectableTable-hover');
  },
  function() {
    var row = $(this).parent();
    row.find('td').removeClass('selectableTable-hover');
  }
);