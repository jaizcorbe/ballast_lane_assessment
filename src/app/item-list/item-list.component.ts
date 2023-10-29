import { Component, Input } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent {
  @Input() title = 'Item List';
  @Input() items: any[] = [];
  @Input() itemDetailPath: string = '/';
  @Input() itemDescription: (item: any) => string = (item) => item.name;

  constructor(private router: Router) {}

  onItemSelected(selectedItem: any): void {
    const url = `${this.itemDetailPath}/${selectedItem.id}`
    console.info("Calling url" + url)
    this.router.navigateByUrl(this.itemDetailPath);
  }

}
