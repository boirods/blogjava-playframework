import { ComponentFixture, TestBed } from '@angular/core/testing';

import { IndexPostsComponent } from './index-posts.component';

describe('IndexPostsComponent', () => {
  let component: IndexPostsComponent;
  let fixture: ComponentFixture<IndexPostsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ IndexPostsComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(IndexPostsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
