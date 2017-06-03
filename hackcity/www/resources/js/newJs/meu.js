$(document).ready(function() 
{
  jQuery('body').on('keypress', 'input, select, textarea', function(e) 
{
var self = $(this), form = self.parents('form:eq(0)'), focusable, next;

if (e.keyCode == 13) {
    if (this.type == 'button'){
      
    }else{
      focusable = form.find('input, a, select, textarea').filter(':visible');
      var nextIndex = focusable.index(this) == focusable.length +1 ? 0 : focusable.index(this) + 1;
      next = focusable.eq(nextIndex);
      next.focus();
      return false;
    }
} 
  });
});