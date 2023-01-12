extends Node2D

var rotation  = self.get_rot()
var direction = Vector2(sin(rotation), cos(rotation))

var distance_from_me = 100 #need to best adjusted by you
var spawn_point      = self.get_global_pos() + direction * distance_from_me

var bullet = bullet_scene.instance()
var wolrd  = self.get_node("../world") #of wherever you're bullet should spawn, but don't spawn it as a player child
world.add_child(bullet)
bullet.set_global_pos(spawn_point)
