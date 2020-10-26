import { Directive, Input, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appUnless]'
})
export class UnlessDirective {

  @Input() set appUnless(condition: boolean){
    if(!condition){
      this.viewConRef.createEmbeddedView(this.templateRef);
    }else{
      this.viewConRef.clear();
    }
  }

  constructor(private templateRef: TemplateRef<any>, private viewConRef: ViewContainerRef) { }

}
