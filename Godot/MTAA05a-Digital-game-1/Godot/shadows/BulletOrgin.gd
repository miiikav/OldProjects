extends Position2D

var force = Vector2(0,0)
var source
var die_on_timeout = true
export var take_player_speed = 0.5
export var speed = 60.0
export var time_left = 10.0
export var damage = 1.0
var animationPlayer
export var dangerous = true

func _ready():
	set_fixed_process(true)
	animationPlayer = get_node("AnimationPlayer")
	animationPlayer.connect("finished", self, "anim_player_finished")

func _process(delta):
	time_left -= delta
	if((time_left <= 0.0) and (die_on_timeout)):
		dangerous = false
		animationPlayer.play("die")
		die_on_timeout = false
	if (dangerous):
		set_linear_velocity(get_linear_velocity() + force)
		force = force.linear_interpolate(Vector2(0,0), delta*4)
		for body in get_colliding_bodies():
			if(body.has_method("damage")):
				body.damage(source,damage)
			dangerous = false
			if (die_on_timeout):
				animationPlayer.play("die")
func anim_player_finsihed():
	if(!dangerous):
		queue_free()
