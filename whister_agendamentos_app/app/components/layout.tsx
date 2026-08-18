import { Menu } from "./menu/menu";

interface LayoutProps {
    children?: React.ReactNode;
}

export const Layout: React.FC<LayoutProps> = (props: LayoutProps) => {
    return (
        <div>

            <section>
                <Menu />

                <div>
                    {props.children}
                </div>
            </section>


        </div>
    );
}