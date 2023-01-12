extends Sprite

func _process(_delta):
	var mpos = get_global_mouse_position()
	look_at(mpos)

func _ready():
	set_process(true)
